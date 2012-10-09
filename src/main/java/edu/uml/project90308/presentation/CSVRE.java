package edu.uml.project90308.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *  This code was documented in the OReilly book "Java Cookbook"
 *  and has been modified by Peter G. Martin
 */
/*
 * The Original Author of this code is Ian Darwin, http://www.darwinsys.com/.
 *      Some code from the O'Reilly Java Cookbook, Second Edition,
 *       ISBN-10: 0-596-00701-9 | ISBN-13: 9780596007010
 */
public class CSVRE
{
    /** The rather involved pattern used to match CSV's consists of three
     * alternations: the first matches aquoted field, the second unquoted,
     * the third a null field.
     */
    public static final String CSV_PATTERN = "\"([^\"]+?)\",?|([^,]+),?|,";
    private static Pattern csvRE;

    /** Construct a regex-based CSV parser. */
    public CSVRE()
    {
        csvRE = Pattern.compile(CSV_PATTERN);
    }

//  /** Process one file. Delegates to parse() a line at a time */
//  private void process(BufferedReader in) throws IOException
//  {
//    String line;
//    // For each line...
//    while ((line = in.readLine()) != null)
//    {
//      //System.out.println("line = " + line);
//      List l = parse(line);
//      if (false) // gratuitous debugging info
//      {
//        System.out.println("Found " + l.size() + " items.");
//        for (int i = 0; i < l.size() - 1; i++)
//        {
//          System.out.print(((String)l.get(i)).trim() + ", ");
//        }
//        System.out.print(((String)l.get(l.size() - 1)).trim());
//        System.out.println();
//      }
//    }
//  }

    /** Parse one line.
     * @return List of Strings, minus their double quotes
     */
    public List<String> parse(String line) {
        //System.out.println(m.groupCount());
        List<String> list = new ArrayList<String>();
        Matcher m = csvRE.matcher(line);
        // For each field
        while (m.find())
        {
            String match = m.group();
            if (match == null)
                break;
            if (match.endsWith(","))
            {
                // trim trailing ,
                match = match.substring(0, match.length() - 1);
            }
            else if (match.endsWith("\t"))
            {
                // trim trailing tab
                match = match.substring(0, match.length() - 1);
            }
            try
            {
                if (match.startsWith("\"") && match.length() >= 2)
                { // assume also ends with
                    match = match.substring(1, match.length() - 1);
                }
                if (match.length() == 0)
                    match = null;
                //System.err.println("ADDING [" + match + "]");
                list.add(match);
            }
            catch (Exception er)
            {
                System.err.println("skipping line [" + line + "] because " +
                        er.toString());
            }
        }
        return list;
    }

}

