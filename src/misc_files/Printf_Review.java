
public class Printf_Review {
		public static void main(String[] args) {
			/* 
			 * Chris Simpauco 
			 * Printf practice 
			 */
			
			//Part 1
			System.out.printf("%.5f %n%n", 1.0/7.0); 
			
			//Part 2
			String name = "Bessy";
			String colour = "brown";
			int weight = 1200;
			System.out.printf("The cow's name is %s, she is %s and weigs %d %n%n", name, colour, weight);
			
			//Part 3
			int xx = 123;
			System.out.println("| 12345678 |");
			System.out.println("| ======== |");
			System.out.printf("| %8d |%n", xx);
			System.out.printf("| %08d | %n", xx);
			System.out.printf("| %+8d |%n", xx);
			System.out.printf("| %-8d |%n", xx);
			System.out.printf("| %8.1f |%n", (double)xx);
		}
}
