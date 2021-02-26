package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import functionLib.BooksPayloads;
import io.restassured.path.json.JsonPath;


public class ComplexJsonpars {
	
	@Test
	public void Jsonparse() {
		
		JsonPath js= new JsonPath(BooksPayloads.CoursePrice());
		
		int count= js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase Amount
		int totalAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		//Print Title of the first course


		  String titleFirstCourse=js.get("courses[1].title");
		  System.out.println(titleFirstCourse);
		  
		//Print All course titles and their respective Prices
		  
		  for(int i=0;i<count;i++)
		  {
			  String courseTitles=js.get("courses["+i+"].title");
			  System.out.println(js.get("courses["+i+"].price").toString());
			  
			  System.out.println(courseTitles);
			  
		  }
		  
		  System.out.println("Print no of copies sold by RPA Course");
		  
		  for(int i=0;i<count;i++)
		  {
		 	  String courseTitles=js.get("courses["+i+"].title");
		 	  if(courseTitles.equalsIgnoreCase("RPA"))
		 	  {
		 		  int copies=js.get("courses["+i+"].copies");
		 		  System.out.println(copies);
		 		  break;
		 	  }
		 	
		 	  
		  }
		  
		  
		  int sum =0;
		  for(int i=0;i<count;i++)
		  {
		 	 
		 	  
		 	 	  int price=js.get("courses["+i+"].price");
		 		  int copies=js.get("courses["+i+"].copies");
		 		  
		 		  sum=sum+price*copies;
		 		  
		 		  
		 	  
		 	
		 	  
		  }
		  
		  
		  System.out.println(sum);
		  
		  Assert.assertTrue(sum==totalAmount);
		
		
	}
	
	

}
