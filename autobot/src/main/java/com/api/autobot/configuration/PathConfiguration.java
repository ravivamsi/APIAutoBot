/**
 * 
 */
package com.api.autobot.configuration;

import java.io.File;

/**
 * @author vamsiravi
 *
 */
public class PathConfiguration {
	
	
//		 OS details from the System 
		public  String operatingSystem = System.getProperty("os.name").toLowerCase();
	
//		User or Project Root Directory
		public String baseDirectory = System.getProperty("user.dir")+File.separator;
	 
//		Reports Directory
		public String reportsDirectory = baseDirectory+"reports"+File.separator;

		/**
		 * @return the operatingSystem
		 */
		public String getOperatingSystem() {
			return operatingSystem;
		}

		/**
		 * @param operatingSystem the operatingSystem to set
		 */
		public void setOperatingSystem(String operatingSystem) {
			this.operatingSystem = operatingSystem;
		}

		/**
		 * @return the baseDirectory
		 */
		public String getBaseDirectory() {
			return baseDirectory;
		}

		/**
		 * @param baseDirectory the baseDirectory to set
		 */
		public void setBaseDirectory(String baseDirectory) {
			this.baseDirectory = baseDirectory;
		}

		/**
		 * @return the reportsDirectory
		 */
		public String getReportsDirectory() {
			return reportsDirectory;
		}

		/**
		 * @param reportsDirectory the reportsDirectory to set
		 */
		public void setReportsDirectory(String reportsDirectory) {
			this.reportsDirectory = reportsDirectory;
		}
		

}
