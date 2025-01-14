import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testParse() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testParse1() throws IOException{
        Path fileName = Path.of("test2.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("some-page.html"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testParse2() throws IOException{
        Path fileName = Path.of("test3.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFail(){
	    assertEquals(2,2);
    }
    @Test
    public void testParse3() throws IOException{
        Path fileName = Path.of("test-file10.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testLab1() throws IOException{
        Path fileName = Path.of("labtest1.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com","google.com","ucsd.edu"), MarkdownParse.getLinks(contents));
    } 
    @Test
    public void testLab2() throws IOException{
        Path fileName = Path.of("labtest2.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("a.com","a.com(())","example.com"), MarkdownParse.getLinks(contents));
    }
     
    @Test
    public void testLab3() throws IOException{
        Path fileName = Path.of("labtest3.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", 
        "https://cse.ucsd.edu/"), MarkdownParse.getLinks(contents));
    } 
}

