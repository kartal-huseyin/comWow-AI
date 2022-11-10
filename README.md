# comWow-AI


	Please kindly run the runner class "src/test/java/runners/Runner.java"
	REPORT can be seen at test-output/Cucumber.html
	SCREENSHOTS can be seen at test-output/*.png
	NOT to be expected to pass all scenarios.

	Since it is not possible to test all function in limited time.
	I have gone for 2nd option (Automation + Test Case)
	I started to test the website manually first.
	Due to one of principle of tests "defects cluster together",
	I focused my automation test on buggy functions.
	The bugs found listed below.

	Bugs:

	Medium Priority: The crucial feature of the website is contaction.
	Contact form accepts names in integer.
	Contact form accepts lastnames in integer.
	Contact form accepts phone numbers in String.
	Contact form accepts invalid mail inputs.
	Contact form accepts large data inputs.

	Low Priority:
	"https://wow-ai.com/event" Expired event accepts applications.

	Minor Bugs (Visual)
	- "https://wow-ai.com/data-annotation" video data annotation expected
	- "https://wow-ai.com/" video slider (It works on firefox not on chrome)
	- "AI solutions for your industry" cursor visual bug
	- "Other special services?" result goes contact page, expected to stay at "https://wow-ai.com/data-transcription"

	Suggestions
	//- limitation can be added for form inputs (It can be a load issue)
	//- location expected (User demand)
