package personal.learn.aditya.operations;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import personal.learn.aditya.utils.FileEntity;

@Path("/{providerName}")
public class AdapterImpl {


	@POST
	@Path("/listFiles")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<FileEntity> getFilesFolder(String payload, @PathParam("providerName") String providerName)
			throws IOException {
		return ProviderFactory.getInstance(providerName).getFilesFolder(new JSONObject(payload));
	}

	@POST
	@Path("/download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public void downloadFile(String payload, @PathParam("providerName") String providerName) throws IOException {
		ProviderFactory.getInstance(providerName).downloadFile(new JSONObject(payload));
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("parentFolderId") String parentFolderId, @PathParam("providerName") String providerName)
			throws IOException {
		ProviderFactory.getInstance(providerName).uploadFile(uploadedInputStream, parentFolderId, fileDetail.getFileName());
	}

}
