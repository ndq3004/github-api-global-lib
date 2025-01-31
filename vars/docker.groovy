/*  
	DESCRIPTION:
	Building a dotnet command
*/

// The call function in a shared library file is used as a constructor
def call(String dockerCmd, Map dockerCmdParams, String sudo = "")
{
	// Iterate over all the dictionary element contains the dotnet file path and dotnet command options
	dockerCmdParams.each{ path, params ->

	try {	
		/* 
		   If you're using Linux - use the sh command
		   If you're using Windows - use the bat command
		   Leave only the relevant command according to your OS
		*/
		
		// Linux:
		// sh "docker ${dockerCmd} ${params}"
		// echo "get here"
		// sh "docker images"
		// sh "docker build -t aspnetapp /home/ec2-user/workspace/PipelineNetcore1/DemoCICDSolution"

		// Windows:
		//bat "dotnet ${dotnetcmd} ${WORKSPACE}/${path} ${params}"

		}

    catch (Exception ex) {
        throw ex
        	}
	}
}