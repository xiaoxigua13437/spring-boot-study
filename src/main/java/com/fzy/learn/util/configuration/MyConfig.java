package com.fzy.learn.util.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 自定义config配置获取
 * 注：application配置文件中的配置不需要@PropertySource加载，能直接获取
 * @author fuzhongyu
 * @date 2018/3/13
 */
@PropertySource(value = "classpath:/config/my-config.properties")
@Component
public class MyConfig {

  @Value("${web.aaa}")
  private String aaa;

  @Value("${api.bbb}")
  private String bbb;

  @Value("${api.ccc}")
  private Integer ccc;

  /**
   * 当application和自定义配置文件中都含有这个属性的时候，会获取到application中的配置
   */
  @Value("${custom.name}")
  private String cName;


  public String getAaa() {
    return aaa;
  }

  public void setAaa(String aaa) {
    this.aaa = aaa;
  }

  public String getBbb() {
    return bbb;
  }

  public void setBbb(String bbb) {
    this.bbb = bbb;
  }

  public Integer getCcc() {
    return ccc;
  }

  public void setCcc(Integer ccc) {
    this.ccc = ccc;
  }

  public String getcName() {
    return cName;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }
}
