package Test;

public class StringTest {
	
	public static void main(String[] args) {
		String url="/1/1.jpg";
		String [] urls=url.split("#");
		for(int i=0;i<urls.length;i++) {
			System.out.println(urls[i]);
		}
		System.out.println();
		System.out.println(url);
	}
}
