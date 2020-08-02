WinWait("File Upload", "", "30")
If WinExists("File Upload") Then
	  Sleep(1500);
	  ControlClick("File Upload", "", "[CLASS:ToolbarWindow32; INSTANCE:3]","right")
	  Sleep(1500);
	  ControlSend("File Upload", "", "[CLASS:ToolbarWindow32; INSTANCE:3]","e")
	  Sleep(1500);
	  Send("{DEL}") ;
	  Sleep(1500);
	  Send($CmdLine[1]);
	  Send("{ENTER}") ;
	  Sleep(1500);
   EndIf

ControlClick("File Upload", "", "Edit1","left")
Sleep(1500);
Local $counter = 2
Do
  Send('"')
  Send($CmdLine[$counter])
  Send('"')
  $counter = $counter + 1
Until $counter = $CmdLine[0] + 1
Sleep(1000);
Send("{ENTER}")