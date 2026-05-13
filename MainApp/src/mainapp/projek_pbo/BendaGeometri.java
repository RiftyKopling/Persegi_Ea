/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapp.projek_pbo;

/*
 * basic entitiy of shape shouldn't force to have hitungLuas nor hitungKeliling
 * because it depends on wich the shape is implement 2d shape or 3d shape
 */
public interface BendaGeometri {
    public abstract String getNamaBangun();
    public abstract String info();
    public abstract String infoSingleLine();
}
