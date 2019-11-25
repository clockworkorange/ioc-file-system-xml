package es.jripoll.ioc.filesystemxml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IocFileSystemXmlApplicationTests {

	@Test
	public void testBasicUsage() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"//tmp/filesystemxmlapplicationcontext-example.xml"
		);
		Product Product = (Product) context.getBean("product");
		assertEquals(Product.getSku(), "SKU-987654321");
		assertEquals(Product.getName(), "Red Shirt");
		assertEquals(Product.getStock(), 13);

		Product sameProduct = context.getBean("product", Product.class);
		assertEquals(sameProduct.getSku(), "SKU-987654321");
		assertEquals(sameProduct.getName(), "Red Shirt");
		assertEquals(sameProduct.getStock(), 13);
	}
}
