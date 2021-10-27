package decorator;

import org.displaytag.decorator.TableDecorator;

import beanDTO.AsesorDTO;

public class DevolverEmp extends TableDecorator {

	
	public String getDevolverEmpleado(){
		
		AsesorDTO ases = (AsesorDTO) getCurrentRowObject();
		
		int cod = ases.getCod_ases(); 
		String dni= ases.getNumIdentidad_ases();
		String nom= ases.getNom_ases();
		String pat= ases.getApePat_ases();
		String mat = ases.getApeMat_ases();
		String dir = ases.getDirrec_ases();
		String fec= ases.getFechaNac_ases();
		String cor = ases.getCorreo_ases();
		int     num = ases.getNum_telefono_ases();
		int     ref = ases.getRef_telefono_ases();
		//int  tel = ases.getNumTelfijo_ases();
		String dis = ases.getDistrito_ases();
		String pro = ases.getProvincia_ases();
		String dep = ases.getDepartamento_ases();
		
	return "<a = href='MantenerEmpleado.jsp?cod="+cod+"&dni="+dni+"&nom="+nom+"&pat="+pat+"&mat="+mat+"&dir="+dir+"&fec="+fec+"&cor="+cor+"&ref="+ref+"&num="+num+"&dis="+dis+"&pro="+pro+"&dep="+dep+"'>"
			+ "<img  src=\"img/nuevo.png\" onmouseover =\"src='img/nuevo2.png'\" onmouseout=\"src='img/nuevo.png'\"> </a>";

		
		
	
	}
}
