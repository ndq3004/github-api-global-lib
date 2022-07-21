/*  
	DESCRIPTION:
	Building a dotnet command
*/
import java.io.File

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
		File file = new File("/home/ec2-user/netcore/PipelineNetcore1/${path}")
        String currentDir = new File(".").getAbsolutePath()
        echo currentDir
        if(file.exists()){
            echo "file exists!"
        }else{
            echo "file not exists!"
        }
        
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