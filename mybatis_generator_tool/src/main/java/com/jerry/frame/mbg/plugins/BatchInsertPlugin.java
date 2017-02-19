package com.jerry.frame.mbg.plugins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.IntrospectedTable.TargetRuntime;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.internal.rules.Rules;

public class BatchInsertPlugin extends PluginAdapter
{
  private static final String METHOD_NAME = "insertBatch";

  public boolean validate(List<String> warnings)
  {
    return true;
  }

  public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
  {
    if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
      addInsertMethod(interfaze, introspectedTable);
    }

    return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
  }

  public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable)
  {
    if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
      addElements(document.getRootElement(), introspectedTable);
    }
    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  private void addElements(XmlElement parentElement, IntrospectedTable introspectedTable)
  {
    XmlElement answer = new XmlElement("insert");

    answer.addAttribute(new Attribute("id", "insertBatch"));

    FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();

    answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName()));

    this.context.getCommentGenerator().addComment(answer);

    GeneratedKey gk = introspectedTable.getGeneratedKey();
    if (gk != null) {
      IntrospectedColumn introspectedColumn = introspectedTable.getColumn(gk.getColumn());

      if (introspectedColumn != null) {
        if (gk.isJdbcStandard()) {
          answer.addAttribute(new Attribute("useGeneratedKeys", "true"));

          answer.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));
        }
        else {
          answer.addElement(getSelectKey(introspectedColumn, gk));
        }
      }
    }

    StringBuilder insertClause = new StringBuilder();
    StringBuilder valuesClause = new StringBuilder();

    insertClause.append("insert into ");
    insertClause.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());

    insertClause.append(" (");

    valuesClause.append("values <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" > (");

    List valuesClauses = new ArrayList();
    Iterator iter = introspectedTable.getAllColumns().iterator();

    while (iter.hasNext()) {
      IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
      if (!introspectedColumn.isIdentity())
      {
        insertClause.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));

        valuesClause.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "item."));

        if (iter.hasNext()) {
          insertClause.append(", ");
          valuesClause.append(", ");
        }

        if (valuesClause.length() > 80) {
          answer.addElement(new TextElement(insertClause.toString()));
          insertClause.setLength(0);
          OutputUtilities.xmlIndent(insertClause, 1);

          valuesClauses.add(valuesClause.toString());
          valuesClause.setLength(0);
          OutputUtilities.xmlIndent(valuesClause, 1);
        }
      }
    }
    insertClause.append(')');
    answer.addElement(new TextElement(insertClause.toString()));

    valuesClause.append(")</foreach>");
    valuesClauses.add(valuesClause.toString());

    for (Object clause : valuesClauses) {
      answer.addElement(new TextElement(clause.toString()));
    }

    parentElement.addElement(answer);
  }

  protected XmlElement getSelectKey(IntrospectedColumn introspectedColumn, GeneratedKey generatedKey)
  {
    String identityColumnType = introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName();

    XmlElement answer = new XmlElement("selectKey");
    answer.addAttribute(new Attribute("resultType", identityColumnType));
    answer.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));

    answer.addAttribute(new Attribute("order", generatedKey.getMyBatis3Order()));

    answer.addElement(new TextElement(generatedKey.getRuntimeSqlStatement()));

    return answer;
  }

  private void addInsertMethod(Interface interfaze, IntrospectedTable introspectedTable)
  {
    Set importedTypes = new TreeSet();
    Method method = new Method();

    method.setReturnType(new FullyQualifiedJavaType("void"));
    method.setVisibility(JavaVisibility.PUBLIC);
    method.setName("insertBatch");

    FullyQualifiedJavaType parameterType = introspectedTable.getRules().calculateAllFieldsClass();

    importedTypes.add(parameterType);

    FullyQualifiedJavaType listParamType = new FullyQualifiedJavaType(new StringBuilder().append("java.util.List<").append(parameterType).append(">").toString());

    method.addParameter(new Parameter(listParamType, "recordLst"));

    this.context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

    interfaze.addImportedTypes(importedTypes);
    interfaze.addMethod(method);
  }
}