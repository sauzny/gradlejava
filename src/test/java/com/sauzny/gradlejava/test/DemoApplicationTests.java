package com.sauzny.gradlejava.test;

import java.io.IOException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.sauzny.gradlejava.service.AttributesS;
import com.sauzny.gradlejava.service.ComputervisionS;
import com.sauzny.gradlejava.service.DetectS;
import com.sauzny.gradlejava.utils.SpringUtils;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

	// spring test 获取 applicationContext
	@Autowired ApplicationContext applicationContext;
	
	@Autowired AttributesS attributesS;
	@Autowired ComputervisionS computervisionS;
	@Autowired DetectS detectS;
	
	
	//@Test
	public void contextLoads() throws IOException {
		
		SpringUtils.setApplicationContext(applicationContext);
		
		String image_001 = "http://fmn.rrfmn.com/fmn058/20120403/2100/large_rbDe_729d0000138a125c.jpg";
		String image_002 = "http://www.publicdomainpictures.net/pictures/20000/velka/family-of-three-871290963799xUk.jpg";
		String image_003 = "http://b.hiphotos.baidu.com/baike/crop%3D0%2C0%2C1024%2C676%3Bc0%3Dbaike116%2C5%2C5%2C116%2C38/sign=45840bfe272eb938f82220b2e852a905/2934349b033b5bb5d88928e13ed3d539b600bc56.jpg";
		
		String image_004 = "http://www.fathersez.com/wp-content/uploads/2008/09/giza-pyramids.jpg";
		String image_005 = "https://www.mega2018.org.uk/Images/welcome-to-yorkshire.jpg";
		String image_006 = "http://imgsrc.baidu.com/baike/pic/item/61183b2db605f30c349bf7cd.jpg";
		String image_007 = "http://e.hiphotos.baidu.com/zhidao/pic/item/ae51f3deb48f8c5420ad294c3c292df5e0fe7f53.jpg";
			
		//attributesS.apply(requestId, CognitivejManager.DetectAllAttributesExample, new String[]{image_003});
		//attributesS.apply(requestId, CognitivejManager.DetectFacialLandmarksExample, new String[]{image_001});
		//attributesS.apply(requestId, CognitivejManager.DetectGenderAgeFromFileExample, new String[]{image_001});
		//attributesS.apply(requestId, AttributesS.Type.detectGenderAgeFromURLExample, new String[]{image_001});
		
		
		//computervisionS.apply(requestId, ComputervisionS.Type.describeImageExample, new String[]{image_001});
		computervisionS.apply("2313", ComputervisionS.Type.ocrImageExample.toString(), new String[]{image_007});
		
		//detectS.apply(requestId, DetectS.Type.detectFacesFromImageUrlExample, new String[]{image_001});
		//detectS.apply(requestId, DetectS.Type.detectSingleFaceFromFileExample, new String[]{image_001});
	}

}
