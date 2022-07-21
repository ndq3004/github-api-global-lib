/*  
	DESCRIPTION:
	Building a dotnet command
*/


// The call function in a shared library file is used as a constructor
def call(String dotnetcmd, Map dotnetcmdParams, String sudo = "")
{
	// Iterate over all the dictionary element contains the dotnet file path and dotnet command options
	dotnetcmdParams.each{ path, params ->

	try {	
		/* 
		   If you're using Linux - use the sh command
		   If you're using Windows - use the bat command
		   Leave only the relevant command according to your OS
		*/
		echo path
        
		// Linux:
		sh "dotnet ${dotnetcmd} /home/ec2-user/netcore/PipelineNetcore1/${path} ${params}"

		// Windows:
		bat "dotnet ${dotnetcmd} ${WORKSPACE}/${path} ${params}"

		}

    catch (Exception ex) {
        throw ex
        	}
	}
}