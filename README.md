BlackJack
=========

BlackJack Program for our Group Project

To import the WhiteJack project in Eclipse WITHOUT eGIT plugin installed:

1) Go to Downloads\n

2) Download either as .zip or .tar file.\n

3) Unzip the folder, you should see AfterKraft-BlackJack-lotsofnumbershere\n

4) In Eclipse: Create a new Java Project-Name however you wish\

5) Drag and drop the src folder from AfterKraft-BlackJack-lotsofnumbers into your new Java Project

6) Code away!


To import the WhiteJack project in Eclipse WITH eGit plugin installed:

1) Open the Git Repositories view by going to Window>Show View> Other >Git > Git Repositories

2) Click on the "Clone a Git Repository" button, should be a folder with an arrow curving downwards

3) Copy Paste the link: https://github.com/AfterKraft/BlackJack.git into the URI area

4) Under the Authentication field, type in your username you registered with GitHub and the password,

Store in Secure Store so you don't have to continue to enter the password constantly

5) Select BlackJack [master] in the Git Repositories view and right click "Import Projects"

6) In the next window, Select: "Import as General Project"

7) Open the .project file in the BlackJack project folder

8) Paste over the <natures></natures> with:

  <natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
  
9) Project should be clean and ready to work!

NetBeans info to come as soon as I have time to install and test it.