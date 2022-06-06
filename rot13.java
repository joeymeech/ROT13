import java.util.Scanner;

public class rot13{

	private String encrypted = "";
	private String decrypted = "";

	public String encryptString(String plainText){
		int ascii;
		for(char c : plainText.toCharArray()){
			ascii = (int) c;
			if(Character.isLetter(c)){
				ascii += 13;
				if(Character.isUpperCase(c)){
					// if there is wrap around
					if(ascii > 90){
						// find remandiner of wrap around and add to base capital letter(65)
						ascii = (ascii%91) + 65;
					}
				}
				else if(Character.isLowerCase(c)){
					if(ascii > 122){
						ascii = (ascii%123) + 97;
					}
				}
				c = (char) ascii;
			}
			encrypted = encrypted + c;
		
		}
		System.out.println("Your encrypted text: ");
		return encrypted;	
	
	}

	public String decryptString(String enryptedText){
		int ascii;
		for(char c : enryptedText.toCharArray()){
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
		System.out.println("Your decrypted text: ");
		return decrypted;	
	
	}


	public static void main(String[] args){
		rot13 cipher = new rot13();
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		System.out.println("This script encrypts and decrpts your text using the rot13 cipher(Shout out the romans)");
		while (check){
			System.out.println("Select a number to contine: ");
			System.out.println("[1] encrypt text");
			System.out.println("[2] decrypt text");
			System.out.println("[3] quit");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num){
				case 1:
					System.out.print("Enter your text: ");
					String plainText = sc.nextLine();
					System.out.println(cipher.encryptString(plainText) + "\n");
					break;
				case 2:
					System.out.print("Enter your text: ");
					String enryptedText = sc.nextLine();
					System.out.println(cipher.decryptString(enryptedText) + "\n");
					break;
				case 3:
					sc.close();
					check = false;
					break;
				default:
					System.out.println("Invalid number! Try again \n");
			}

		}

	}
}
