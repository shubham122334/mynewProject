
package p;

public class IdMaker {

	public static String IdMkr(String str){

		char ch[]=str.toCharArray();
		if(ch[0]<='0'||ch[0]<='9')
			ch[0]='A';
		for(int i=ch.length-1;i>=1;i--)
		{
		if(ch[i]=='9' && i==1)
		{
			ch[i-1]=++ch[i-1];
			while(i<ch.length) {ch[i]='0';i++;}
			break;
		}
		else if(ch[i]=='9')
		{
			continue;
		}	
		else if(ch[i]!=9)
			{
			int key=(int)ch[i];
			key++;
			ch[i]=(char)key;
			while(i<ch.length-1) {++i;ch[i]='0';}
			break;
			}
		}
		
		return new String(ch);
	}
	
}