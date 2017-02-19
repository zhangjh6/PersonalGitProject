
package com.jerry.frame.mbg;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMWriter;
import org.dom4j.io.SAXReader;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.MyBatisGeneratorConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;


public class MbgRunner {
    
    private static Logger logger = org.apache.log4j.Logger.getLogger(MbgRunner.class);
    
    public static void main(String[] args) throws Exception{
        
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        try{
            InputStream inputStream = MbgRunner.class.getClassLoader().getResourceAsStream("generatorConfig-oracle.xml");

            Configuration config = parseMyBatisGeneratorConfiguration(parseXmlW3C(inputStream));
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            
        } catch(Exception err){
            logger.error(err);
        }
       
        for (String warning : warnings) {
            logger.info(warning);
        }
        

    }
    
    public static Element parseXml(InputStream inputStream) throws Exception{
        SAXReader sr = new SAXReader(); 
            Document doc  =  sr.read(inputStream);
            Element root = doc.getRootElement();  
        return root;
    }
    
    public static org.w3c.dom.Element parseXmlW3C(InputStream inputStream) throws Exception{
        SAXReader sr = new SAXReader(); 
        Document doc  =  sr.read(inputStream);
        //Element root = doc.getRootElement();
        DOMWriter writer = new DOMWriter();
        org.w3c.dom.Document doc2 = writer.write(doc);
        return doc2.getDocumentElement();
    }
    
    private static Configuration parseMyBatisGeneratorConfiguration(org.w3c.dom.Element rootNode)   throws XMLParserException ,DocumentException{
        MyBatisGeneratorConfigurationParser parser = new MyBatisGeneratorConfigurationParser(
                System.getProperties());
        return parser.parseConfiguration(rootNode);
    }
    
    public static org.w3c.dom.Element convert( org.dom4j.Element element) throws DocumentException{  
        org.dom4j.Document doc1 = DocumentHelper.createDocument();  
        doc1.setRootElement(element);  
        // Convert dom4j document to w3c document  
        DOMWriter writer = new DOMWriter();  
        org.w3c.dom.Document doc2 = writer.write( doc1);  
        
        return doc2.getDocumentElement() ;  
      }  
}

