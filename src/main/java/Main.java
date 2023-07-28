import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        for(String arg:args)
        {
            System.out.println(arg);
        }
        System.out.println("CLI tool made by Mughees Qasim");
        if(args.length!=2)
        {
            System.out.println("ccwc: wrong command usage");
            System.out.println("usage: ccwc [-c/l/m/w] [fileName....]");
            return;
        }
        final char type = args[0].charAt(1);
        final String fileName = args[1];

        long numCharacters = 0;
        long numWords = 0;
        long numLines = 0;

        try {
            InputStream fs = Files.newInputStream(Paths.get(fileName));
            InputStreamReader isr = new InputStreamReader(fs);

            if(type=='c')
            {
                long numBytes = 0;
                int bytesRead;
                byte[] buffer = new byte[1024];
                while((bytesRead = fs.read(buffer)) !=-1)
                {
                    numBytes += bytesRead;
                }
                System.out.println("number of bytes in " + fileName + " = " + numBytes);
                return;
            }

            StringBuilder sb = new StringBuilder();
            int val;
            while ((val=isr.read()) != -1) {
                numCharacters++;

                if((char)val=='\n')
                {

                    if(!sb.toString().isEmpty())
                    {
                        StringTokenizer tokenizer = new StringTokenizer(sb.toString());
                        numWords += tokenizer.countTokens();
                    }
                    sb = new StringBuilder();
                    numLines++;
                }

                sb.append((char)val);
            }

            switch(type)
            {
                case 'l':
                    System.out.println("numbers of lines in " + fileName + " = " + numLines);
                    break;
                case 'm':
                    System.out.println("number of characters in " + fileName + " = " + numCharacters);
                    break;
                case 'w':
                    System.out.println("number of words in " + fileName + " = " + numWords);
                    break;
                default:
                    System.out.println("ccwc: illegal option --" + type);
                    System.out.println("usage: ccwc [-c/l/m/w] [fileName....]");
                    break;
            }
        } catch (Exception exc) {
            System.out.println("ccwc:" + exc.getMessage());
        }
    }
}
