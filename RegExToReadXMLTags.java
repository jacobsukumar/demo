import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExToReadXMLTags {
	
	
	public static void main(String[] args) {
		
		 final String str = "<fc:inflationCoverage><fc:coverageAIndex>123</fc:coverageAIndex><fc:coverageBIndex>123</fc:coverageBIndex>"
		 		+ ""
		 		+ "<fc:coverageAIndex>N/A</fc:coverageAIndex><fc:coverageBIndex>N/A</fc:coverageBIndex>123</fc:inflationCoverage>";
		 System.out.println(getTagValues(str,TAG_REGEX_COVERAGEA));
		 System.out.println(getTagValues(str,TAG_REGEX_COVERAGEB));
	}

	private static final Pattern TAG_REGEX_COVERAGEA = Pattern.compile("<fc:coverageAIndex>(.+?)</fc:coverageAIndex>");
	private static final Pattern TAG_REGEX_COVERAGEB = Pattern.compile("<fc:coverageBIndex>(.+?)</fc:coverageBIndex>");

	private static List<String> getTagValues(final String str,Pattern pattern) {
	    final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = pattern.matcher(str);
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	    }
	    return tagValues;
	}
	

}
