import java.util.Scanner;

public class rot13{

	private int ascii;

	public String cryptString(String text){
		String decrypted = "";
		for(char c : text.toCharArray()){
			ascii = (int) c;
			if(Character.isLetter(c)){
				ascii -= 13;
				if(Character.isUpperCase(c)){
					if(ascii < 65){
						// wrap around for going backwards subtract last letter(Z) ascii from wrap around amnount(remainder)
						ascii = 90 - (64%ascii);
					}
				}
				else if(Character.isLowerCase(c)){
					if(ascii < 97){
						ascii = 122 - (96%ascii);
					}
				}
				c = (char) ascii;
			}
			decrypted = decrypted + c;
		
		}
		System.out.println("Your encrypted/decrypted text: ");
		return decrypted;	
	
	}


	public static void main(String[] args){
		rot13 cipher = new rot13();
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		System.out.println("This script encrypts and decrpts your text using the rot13 cipher(Shout out the romans)");
		while (check){
			System.out.println("Select a number to contine: ");
			System.out.println("[1] encrypt/decrypt text");
			System.out.println("[2] quit");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num){
				case 1:
					System.out.print("Enter your text: ");
					String text = sc.nextLine();
					System.out.println(cipher.cryptString(text) + "\n");
					break;
				case 2:
					sc.close();
					check = false;
					break;
				default:
					System.out.println("Invalid number! Try again \n");
			}

		}

	}
}
