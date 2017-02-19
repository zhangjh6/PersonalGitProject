package com.jerry.frame.mbg.plugins;
import java.util.List;
import java.util.Properties;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
/**
 * 自动生成分页查询mapper
 * @author Administratori
 *
 */
public class OraclePaginationPlugin extends PluginAdapter
{
  public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
  {
    String superClass = getProperties().getProperty("rootClass");
    if ((superClass != null) && (!"".equalsIgnoreCase(superClass.trim())) && (superClass.trim().length() != 0))
    {
      topLevelClass.setSuperClass(superClass);
      topLevelClass.addImportedType(superClass);
    }

    return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
  }

  public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
  {
    XmlElement isStart = new XmlElement("if");
    isStart.addAttribute(new Attribute("test", "limitClauseStart != null and limitClauseStart >= 0"));
    isStart.addElement(new TextElement(" select * from (select t_1.*,rownum as row_num from ("));

    element.getElements().add(0, isStart);

    XmlElement isNotNullElement = new XmlElement("if");
    isNotNullElement.addAttribute(new Attribute("test", "limitClauseStart != null and limitClauseStart >= 0"));
    isNotNullElement.addElement(new TextElement(" <![CDATA[ ) t_1 where rownum<=#{limitClauseCount,jdbcType=INTEGER} + #{limitClauseStart,jdbcType=INTEGER}) t_2 where t_2.row_num>#{limitClauseStart,jdbcType=INTEGER}]]>"));

    element.getElements().add(element.getElements().size(), isNotNullElement);

    return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
  }

  public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
  {
    XmlElement isStart = new XmlElement("if");
    isStart.addAttribute(new Attribute("test", "limitClauseStart != null and limitClauseStart >= 0"));
    isStart.addElement(new TextElement("select * from (select t_1.*,rownum as row_num from ("));

    element.getElements().add(0, isStart);

    XmlElement isNotNullElement = new XmlElement("if");
    isNotNullElement.addAttribute(new Attribute("test", "limitClauseStart != null and limitClauseStart >= 0"));
    isNotNullElement.addElement(new TextElement(" <![CDATA[ ) t_1 where rownum<=#{limitClauseCount,jdbcType=INTEGER} + #{limitClauseStart,jdbcType=INTEGER}) t_2 where t_2.row_num>#{limitClauseStart,jdbcType=INTEGER}]]>"));

    element.getElements().add(element.getElements().size(), isNotNullElement);

    return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
  }

  public boolean validate(List<String> warnings)
  {
    return true;
  }
}