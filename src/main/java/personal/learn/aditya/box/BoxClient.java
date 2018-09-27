package personal.learn.aditya.box;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFile;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;

import personal.learn.aditya.operations.SupportedOperations;
import personal.learn.aditya.utils.FileEntity;
import personal.learn.aditya.utils.FileType;

public class BoxClient implements SupportedOperations {

	private static BoxAPIConnection client;

	public BoxClient() throws IOException {
		// Create new basic client with developer token
		client = new BoxAPIConnection(BoxConstants.DEVELOPER_TOKEN);
	}

	public List<FileEntity> getFilesFolder(JSONObject payload) {
		List<FileEntity> fileEntityList = new ArrayList<FileEntity>();
		BoxFolder folder = new BoxFolder(client, payload.getString(BoxConstants.FOLDERID));
		for (BoxItem.Info itemInfo : folder) {
			FileEntity file = new FileEntity();
			if (itemInfo instanceof BoxFile.Info) {
				BoxFile.Info fileInfo = (BoxFile.Info) itemInfo;
				file.setName(fileInfo.getName());
				file.setFileId(fileInfo.getID());
				file.setType(FileType.FILE);
			} else if (itemInfo instanceof BoxFolder.Info) {
				BoxFolder.Info folderInfo = (BoxFolder.Info) itemInfo;
				file.setName(folderInfo.getName());
				file.setFileId(folderInfo.getID());
				file.setType(FileType.FOLDER);
			}
			fileEntityList.add(file);
		}
		return fileEntityList;

	}

	public void uploadFile(InputStream stream, String parentFolderId, String fileName) throws IOException {
		BoxFolder destination = new BoxFolder(client, parentFolderId);
		BoxFile.Info newFileInfo = destination.uploadFile(stream, fileName);
		stream.close();
	}

	public void downloadFile(JSONObject payload) throws IOException {
		BoxFile file = new BoxFile(client, payload.getString(BoxConstants.FILEID));
		BoxFile.Info info = file.getInfo();
		FileOutputStream stream = new FileOutputStream(info.getName());
		file.download(stream);
		stream.close();
	}
}
