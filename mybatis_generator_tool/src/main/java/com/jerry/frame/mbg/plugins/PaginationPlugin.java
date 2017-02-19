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
 * mysql分页mapper
 * @author Administratori
 *
 */
public class PaginationPlugin extends PluginAdapter
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
    XmlElement isNotNullElement = new XmlElement("if");
    isNotNullElement.addAttribute(new Attribute("test", "limitClauseStart != null and limitClauseStart >= 0"));
    isNotNullElement.addElement(new TextElement(" limit #{limitClauseStart,jdbcType=INTEGER}, #{limitClauseCount,jdbcType=INTEGER}"));

    element.getElements().add(element.getElements().size(), isNotNullElement);

    return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
  }

  public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
  {
    XmlElement isNotNullElement = new XmlElement("if");
    isNotNullElement.addAttribute(new Attribute("test", "limitClauseStart != null and limitClauseStart >= 0"));
    isNotNullElement.addElement(new TextElement(" limit #{limitClauseStart,jdbcType=INTEGER}, #{limitClauseCount,jdbcType=INTEGER}"));

    element.getElements().add(element.getElements().size(), isNotNullElement);

    return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
  }

  private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name)
  {
  }

  public boolean validate(List<String> warnings)
  {
    return true;
  }
}