import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/");
    assertEquals("There are 1391 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?q=Resonance");
    String expect = "Found 2 paths:\n./technical/biomed/ar615.txt\n./technical/plos/journal.pbio.0020150.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}
    @Test 
	public void testBadParameterSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?s=asdf");
    String expect = "Couldn't find query parameter q";
    assertEquals(expect, h.handleRequest(rootPath));
	}
    @Test 
	public void testBadDirectorySearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/lookforasdf");
    String expect = "Don't know how to handle that path!";
    assertEquals(expect, h.handleRequest(rootPath));
	}
}

