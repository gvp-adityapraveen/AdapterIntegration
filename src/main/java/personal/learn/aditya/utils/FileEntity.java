package personal.learn.aditya.utils;

public class FileEntity {

	private String name;
	private String fileId;
	private FileType type;

	/**
	 * Returns the name field of the fileEntity
	 * 
	 * @return name field of the fileEntity
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name field of the fileEntity
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * Returns the type field of FileEntity whether it is file or folder
	 * 
	 * @return type
	 */
	public FileType getType() {
		return type;
	}

	/**
	 * Sets the type field for the fileEntity
	 * 
	 * @param type
	 */
	public void setType(FileType type) {
		this.type = type;
	}
}
