#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char * mo[26] = { ".-", "-...", "-.-.", "-..", ".",            //ABCDE
				  "..-.", "--.", "....", "..", ".---", 	       //FGHIJ
				  "-.-", ".-..", "--", "-.", "---",            //KLMNO
				  ".--.", "--.-", ".-.", "...", "-",           //PQRST
				  "..-", "...-", ".--", "-..-", "-.--", "--.." //UVWXYZ
				};  // Morse Code

char en[52] = {  // Capital Letter
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				// Small Letter
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' 
			  };  // English

void motoen(char * input) {  // Morse => English
	for (int i = 0; i < 26; i++) {
		if (!strcmp(input, mo[i])) {
			printf("%c", en[i]);
		}
	}
}

void entomo(char * input) {  // English => Morse
	for (int i = 0; i < strlen(input); i++) {
		for (int j = 0; j < 26; j++) {
			if (input[i] == en[j] || input[i] == en[j + 26]) {
				printf("%s ", mo[j]);
			}
		}
	}
	printf("\n");
}

int main() {
	char input[100];
	char * p;

	printf("Input : ");
	gets(input);

	printf("Result : ");

	if (input[0] == '.' || input[0] == '-') {
		p = strtok(input, " ");
		motoen(p);
		while (p != NULL) {
			p = strtok(NULL, " ");
			if (p) {
				motoen(p);
			}
		}
		puts("");
	} else {
		entomo(input);
	}
	
	getchar();
	return 0;
}