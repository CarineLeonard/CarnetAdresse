package fr.eni.carnetadresse.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import fr.eni.carnetadresse.bo.Contact;
import fr.eni.carnetadresse.bo.Perso;
import fr.eni.carnetadresse.bo.Pro;
import fr.eni.carnetadresse.dal.ContactsDAO;
import fr.eni.carnetadresse.dal.DALException;

public class ContactsDAOJdbcImpl implements ContactsDAO{
	
	private static final String TYPE_PERSO = "perso";
	private static final String TYPE_PRO= "pro";
	
	private static final String SQL_SelectById = "SELECT nom, prenom, adresse, adresse2, cp, ville, portable, fixe, mail, civilite, datenaissance, entreprise, typecontact FROM Contacts WHERE idContact=?"; 
	private static final String SQL_selectByNom = "SELECT idContact, nom, prenom, adresse, adresse2, cp, ville, portable, fixe, mail, civilite, datenaissance, entreprise, typecontact FROM Contacts WHERE UPPER(nom) like ? and UPPER(prenom) like ?";  
	private static final String SQL_selectByDepartement = "SELECT nom, prenom, adresse, adresse2, cp, ville, portable, fixe, mail, civilite, datenaissance, entreprise, typecontact FROM Contacts WHERE cp like ? ";  
	private static final String SQL_selectAll = "SELECT idContact, nom, prenom, adresse, adresse2, cp, ville, portable, fixe, mail, civilite, datenaissance, entreprise, typecontact FROM Contacts"; 
	private static final String SQL_update = "UPDATE Contacts SET nom=?, prenom=?, adresse=?, adresse2=?, cp=?, ville=?, portable=?, fixe=?, mail=?, civilite=?, datenaissance=?, entreprise=?, typecontact=? WHERE idContact=?"; 
	private static final String SQL_insert = "INSERT INTO Contacts (nom, prenom, adresse, adresse2, cp, ville, portable, fixe, mail, civilite, datenaissance, entreprise, typecontact) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	private static final String SQL_delete = "DELETE FROM Contacts WHERE idContact=?"; 
	
	public Contact afficherContactType(ResultSet rs) throws DALException {
		Contact contact = null; 
		try {
			if (TYPE_PERSO.equalsIgnoreCase(rs.getString("typecontact").trim())) {
				contact = new Perso(rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("adresse2"), 
						rs.getString("cp"), rs.getString("ville"), rs.getString("portable"), rs.getString("fixe"),rs.getString("mail"), rs.getString("civilite"), rs.getDate("datenaissance").toLocalDate());
			} else if (TYPE_PRO.equalsIgnoreCase(rs.getString("typecontact").trim()))  {
				contact = new Pro(rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("adresse2"), 
						rs.getString("cp"), rs.getString("ville"), rs.getString("portable"), rs.getString("fixe"),rs.getString("mail"), rs.getString("civilite"), rs.getString("entreprise"));
			}
			contact.setIdContact(rs.getInt("idContact"));
		} catch (SQLException e) {
			throw new DALException("print type of contacts failed ", e); 
		}
		return contact;
	}

	@Override
	public Contact selectById(int idContact) throws DALException {
		Contact contact = null; 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null; 
		
		try { 
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(SQL_SelectById); 
			stmt.setInt(1, idContact);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				contact = afficherContactType(rs);
			}
			
		} catch (SQLException e) {
			throw new DALException("selectbyId failed ", e); 
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (stmt != null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contact;
	}

	@Override
	public List<Contact> selectByNom(String nom, String prenom) throws DALException {
		Contact contact = null; 
		List<Contact> listContacts = new ArrayList<Contact>();		
		ResultSet rs = null;
		
		try (Connection con = JdbcTools.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL_selectByNom)) {
			stmt.setString(1, "%" + nom.toUpperCase()+ "%");
			stmt.setString(2, "%" + prenom.toUpperCase()+ "%");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				contact = afficherContactType(rs);
				listContacts.add(contact);
			}
			
		} catch (SQLException e) {
			throw new DALException("selectbyNom failed ", e); 
		}
		return listContacts;
	}

	@Override
	public List<Contact> selectByDepartement(String departement) throws DALException {
		Contact contact = null; 
		List<Contact> listContacts = new ArrayList<Contact>();		
		ResultSet rs = null;
		
		try (Connection con = JdbcTools.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL_selectByDepartement)) {
			stmt.setString(1, departement+ "%");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				contact = afficherContactType(rs);
				listContacts.add(contact);
			}
			
		} catch (SQLException e) {
			throw new DALException("selectbyDepartement failed ", e); 
		}
		return listContacts;
	}

	@Override
	public List<Contact> selectAll() throws DALException {
		Contact contact = null; 
		List<Contact> listContacts = new ArrayList<Contact>();		
		ResultSet rs = null;
		
		try (Connection con = JdbcTools.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL_selectAll)) {
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				contact = afficherContactType(rs);
				listContacts.add(contact);
			}
			
		} catch (SQLException e) {
			throw new DALException("selectbyDepartement failed ", e); 
		}
		return listContacts;
	}

	@Override
	public void update(Contact contact) throws DALException {
		try (Connection con = JdbcTools.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL_update)) {
			stmt.setString(1, contact.getNom());
			stmt.setString(2, contact.getPrenom());
			stmt.setString(3, contact.getAdresse());
			stmt.setString(4, contact.getAdresse2());
			stmt.setString(5, contact.getCodepostal());
			stmt.setString(6, contact.getVille());
			stmt.setString(7, contact.getPortable());
			stmt.setString(8, contact.getFixe());
			stmt.setString(9, contact.getEmail());
			stmt.setString(10, contact.getCivilite());
			stmt.setInt(14, contact.getIdContact());
			
			if (contact instanceof Perso) {
				Perso perso = (Perso) contact; 
				stmt.setDate(11, Date.valueOf((LocalDate)perso.getDatenaissance()));
				stmt.setNull(12, Types.NVARCHAR);
				stmt.setString(13, TYPE_PERSO);
			} else if (contact instanceof Pro) {
				Pro pro = (Pro) contact; 
				stmt.setNull(11, Types.NVARCHAR);
				stmt.setString(12, pro.getEntreprise());
				stmt.setString(13, TYPE_PRO);
			}
			stmt.executeUpdate(); 
						
		} catch (SQLException e) {
			throw new DALException("update failed : contact : " + contact, e); 
		}
		
	} //	"INSERT INTO Contacts (nom, prenom, adresse, adresse2, cp, ville, portable, fixe, mail, civilite, datenaissance, entreprise, typecontact) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 


	@Override
	public void insert(Contact contact) throws DALException {
		try (Connection con = JdbcTools.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL_insert, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, contact.getNom());
			stmt.setString(2, contact.getPrenom());
			stmt.setString(3, contact.getAdresse());
			stmt.setString(4, contact.getAdresse2());
			stmt.setString(5, contact.getCodepostal());
			stmt.setString(6, contact.getVille());
			stmt.setString(7, contact.getPortable());
			stmt.setString(8, contact.getFixe());
			stmt.setString(9, contact.getEmail());
			stmt.setString(10, contact.getCivilite());
			
			if (contact instanceof Perso) {
				Perso perso = (Perso) contact; 
				stmt.setDate(11, Date.valueOf((LocalDate)perso.getDatenaissance()));
				stmt.setNull(12, Types.NVARCHAR);
				stmt.setString(13, TYPE_PERSO);
			} else if (contact instanceof Pro) {
				Pro pro = (Pro) contact; 
				stmt.setNull(11, Types.NVARCHAR);
				stmt.setString(12, pro.getEntreprise());
				stmt.setString(13, TYPE_PRO);
			}
			stmt.executeUpdate(); 
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) { 
				contact.setIdContact(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			throw new DALException("insert failed : contact : " + contact, e); 
		}
				
	}

	@Override
	public void delete(int iDContact) throws DALException {
		Contact contact = null; 
		System.out.println(iDContact);
		
		try (Connection con = JdbcTools.getConnection();
				PreparedStatement stmt = con.prepareStatement(SQL_delete)) {
			stmt.setInt(1, iDContact);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DALException("delete failed id"+ iDContact, e); 
		}
				
	}

}
