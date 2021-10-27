package decorator;

import org.displaytag.decorator.TableDecorator;

import beanDTO.ClientesDTO;

public class DevolverCli extends TableDecorator{

	
	public String getDevolverCliente(){
		ClientesDTO  cli = (ClientesDTO) getCurrentRowObject();
		
		String dni= cli.getNumIdentidad_clie();
		String nom= cli.getNom_clie();
		String pat= cli.getApePat_clie();
		String mat = cli.getApeMat_clie();
		String dir = cli.getDirecc_clie();
		String fec= cli.getFechNac_clie();
		String cor = cli.getCorreo_clie();
		int     ref = cli.getNumTrabajo_clie();
		int     cel = cli.getNumCel_clie();
		int  tel = cli.getNumTelfijo_clie();
		String dis = cli.getDistrito_clie();
		String pro = cli.getProvincia_clie();
		String dep = cli.getDepartamento_clie();
	return "<a = href='MantenerCliente.jsp?dni="+dni+"&nom="+nom+"&pat="+pat+"&mat="+mat+"&dir="+dir+"&fec="+fec+"&cor="+cor+"&ref="+ref+"&cel="+cel+"&tel="+tel+"&dis="+dis+"&pro="+pro+"&dep="+dep+"'>"
			+ "<img  src=\"img/nuevo.png\" onmouseover =\"src='img/nuevo2.png'\" onmouseout=\"src='img/nuevo.png'\"> </a>";

		
		
	}
	public String getDevolverMarcador(){
		ClientesDTO  cli = (ClientesDTO) getCurrentRowObject();
		
		String dni= cli.getNumIdentidad_clie();
		String nom= cli.getNom_clie();
		String pat= cli.getApePat_clie();
		String mat = cli.getApeMat_clie();
		String dir = cli.getDirecc_clie();
		String fec= cli.getFechNac_clie();
		String cor = cli.getCorreo_clie();
		int     ref = cli.getNumTrabajo_clie();
		int     cel = cli.getNumCel_clie();
		int  tel = cli.getNumTelfijo_clie();
		String dis = cli.getDistrito_clie();
		String pro = cli.getProvincia_clie();
		String dep = cli.getDepartamento_clie();
	return "<a = href='marcador.jsp?dni="+dni+"&nom="+nom+"&pat="+pat+"&mat="+mat+"&dir="+dir+"&fec="+fec+"&cor="+cor+"&ref="+ref+"&cel="+cel+"&tel="+tel+"&dis="+dis+"&pro="+pro+"&dep="+dep+"'>"
			+ "<img  src=\"img/nuevo.png\" onmouseover =\"src='img/nuevo2.png'\" onmouseout=\"src='img/nuevo.png'\"> </a>";

		
		
	}
}

