interface Logging
{
	public void log(String msg);
}

class LogText implements Logging
{
	public LogText()
	{
		System.out.println("Logging: text format");
	}
	public void log(String msg)
	{	
		System.out.println("Logging text to file: " + msg);
	}
}
class LogXML implements Logging
{
	public LogXML()
	{
		System.out.println("Logging: <type>XML Format</type>");
	}
	public void log(String msg)
	{	
		System.out.println("Logging text to file: log.xml" );
		System.out.println("<xml><msg>"+msg+"</msg></xml>");
	}
}
class LogHTML implements Logging
{
	public LogHTML()
	{
		System.out.println("Logging: HTML format");
	}
	public void log(String msg)
	{	
		System.out.println("Logging HTML to file: log.html" );
		System.out.println("<html><body>"+msg+"</body></html>");
	}
}

class LoggingFactory
{

	public static Logging createLogging(String type){
		if (type.equalsIgnoreCase("xml"))
			return new LogXML();
		else if (type.equalsIgnoreCase("html"))
			return new LogHTML();
		else
			return new LogText();
	}

}

class Analysis
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java Analysis type");
			System.exit(-1);
		}
		String type = args[0];
		Logging logfile = LoggingFactory.createLogging(type);
		logfile.log("Starting application...");

		logfile.log("... read in data file to analyze ...");
		// code...
		logfile.log("... Clustering data for analysis ...");
		// code...
		logfile.log("... Printing analysis results ...");
		// code...
	}
}
