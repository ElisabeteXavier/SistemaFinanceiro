package br.edu.iftm.jsf.bean;

import br.edu.iftm.jsf.entity.Produto;
import br.edu.iftm.jsf.logic.ProdutoLogic;
import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.IOUtils;

@Named
@SessionScoped
@Getter @Setter
public class ProdutoBean extends GenericBean<Produto, ProdutoLogic>{

    @Inject
    private ProdutoLogic logic;
    
    private UploadedFile arquivo;
    
    @Override
    public ProdutoLogic getLogic() {
        return logic;
    }

    @Override
    public Class<Produto> getClassEntity() {
        return Produto.class;
    }
    
       public void handleFileUpload(FileUploadEvent event) {
         try {
            InputStream inputStream = event.getFile().getInputStream();
            getEntity().setFotoUpload(IOUtils.toByteArray(inputStream));
        } catch (IOException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao carregar a imagem");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
}
