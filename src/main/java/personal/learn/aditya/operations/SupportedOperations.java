package personal.learn.aditya.operations;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.JSONObject;

import personal.learn.aditya.utils.FileEntity;

// Adding logging later on
// Add tests as well

public interface SupportedOperations {

	public List<FileEntity> getFilesFolder(JSONObject folderId) throws IOException;

	public void downloadFile(JSONObject fileId) throws IOException;

	public void uploadFile(InputStream stream, String parentFolderId, String fileName)
			throws IOException;

	// Download a File (Can we support multiple download as well)

	// Upload a File (Can we support multiple files upload as well)

}
