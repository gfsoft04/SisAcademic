package br.com.gfsoft.sisacademic.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import de.humatic.dsj.DSCapture;
import de.humatic.dsj.DSEnvironment;
import de.humatic.dsj.DSFilterInfo;
import de.humatic.dsj.DSFiltergraph;

public class WebCamView {
	private static DSCapture player;
	
	
	public static DSCapture getPlayer() {
		return player;
	}

	/**
     * Inicia a conexão com a WebCam
     */
    public static void iniciarWebCam(){
        try {
            File f = new File("lib\\dsj.dll");
            DSFilterInfo[][] dsi = null;
            try {
                if(f.exists())
                    DSEnvironment.setDLLPath(f.getAbsoluteFile().toString());
                 dsi = DSCapture.queryDevices();
            } catch (UnsatisfiedLinkError u) {
                JOptionPane.showMessageDialog(null, "O Arquivo \"dsj.dll\" Não Foi Encontrado Em\n"+f.getAbsolutePath().replace("\\dsj.dll", ""),
                                                    "Atenção", JOptionPane.ERROR_MESSAGE);
            }
            if(dsi[0][0].getName().equalsIgnoreCase("PC Camera"))
                dsi[0][0].setPreferredFormat(2);
            
            player = new DSCapture(DSFiltergraph.DD7, dsi[0][0], false, DSFilterInfo.doNotRender(), null);
            player.setSize(360, 270);
            player.play();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Iniciar a WebCam. Possíveis Causas:"
                                                + "\n- O Aplicativo Já Esta Sendo Executado (Gerenciador de Tarefas -&gt; Processos -&gt; javaw.exe)"
                                                + "\n- A WebCam Está Desconectada"
                                                + "\n- O Windows Não Reconheceu a WebCam",
                                                "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void pararWebCam(){
    	player.dispose();
    }
    
    /**
     * Salva a foto e retorna o caminho
     * @param foto
     * @param caminho
     */
	public static void salvarFoto(BufferedImage foto, File path) {
		try {
			if (!path.exists()){
				File file = new File("img\\");
				file.mkdirs();
				//local.mkdirs();
			}
			ImageIO.write(foto, "PNG", path);
		} catch (IOException e) {
		}
	}

}
