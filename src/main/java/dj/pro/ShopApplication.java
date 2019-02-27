package dj.pro;

import com.fsdcic.box.BoxMachine;
import com.fsdcic.box.adapter.G_queryBox;
import com.fsdcic.box.util.Result;
import dj.pro.Util.Log4jHelper;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ShopApplication extends SpringBootServletInitializer {
	private static Logger log = Log4jHelper.getLogger(ShopApplication.class);

	public static void main(String[] args) {
		log.info("HHHHH");

		//获取所有节日时间
		G_queryBox getHolidayList = new G_queryBox();
		getHolidayList.setBoxId("1111");
		getHolidayList.setDatabaseID("DJSHOP");
		getHolidayList.setSql("select * from user");
		getHolidayList.toBoxs();
		String sql="select * from user";
//		Result result= BoxMachine.executeQuery("DJSHOP",sql);
		Result result= BoxMachine.execute("1111",null);
		log.info(result.toString());
		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShopApplication.class);
	}
}
