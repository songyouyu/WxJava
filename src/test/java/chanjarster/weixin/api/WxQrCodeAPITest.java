package chanjarster.weixin.api;


import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import chanjarster.weixin.bean.result.WxQrCodeTicket;
import chanjarster.weixin.exception.WxErrorException;

import com.google.inject.Inject;

/**
 * 测试用户相关的接口
 * @author chanjarster
 *
 */
@Test(groups = "qrCodeAPI", dependsOnGroups = { "baseAPI" })
@Guice(modules = ApiTestModule.class)
public class WxQrCodeAPITest {

  @Inject
  protected WxServiceImpl wxService;
  
  public void testQrCodeCreateTmpTicket() throws WxErrorException  {
    WxQrCodeTicket ticket = wxService.qrCodeCreateTmpTicket(1, null);
    Assert.assertNotNull(ticket.getUrl());
    Assert.assertNotNull(ticket.getTicket());
    Assert.assertTrue(ticket.getExpire_seconds() != -1);
  }
 
  public void testQrCodeCreateLastTicket() throws WxErrorException  {
    WxQrCodeTicket ticket = wxService.qrCodeCreateLastTicket(1);
    Assert.assertNotNull(ticket.getUrl());
    Assert.assertNotNull(ticket.getTicket());
    Assert.assertTrue(ticket.getExpire_seconds() == -1);
  }
  
}