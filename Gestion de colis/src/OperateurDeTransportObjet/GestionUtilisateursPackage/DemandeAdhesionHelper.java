package OperateurDeTransportObjet.GestionUtilisateursPackage;

/** 
 * Helper class for : DemandeAdhesion
 *  
 * @author OpenORB Compiler
 */ 
public class DemandeAdhesionHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert DemandeAdhesion into an any
     * @param a an any
     * @param t DemandeAdhesion value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHolder(t));
    }

    /**
     * Extract DemandeAdhesion from an any
     * @param a an any
     * @return the extracted DemandeAdhesion value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHolder)
                    return ((OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHolder h = new OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the DemandeAdhesion TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "prenomAdherent";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomAdherent";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "adresseAdherent";
                _members[2].type = OperateurDeTransportObjet.AdresseHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "coordonneesBancaires";
                _members[3].type = OperateurDeTransportObjet.CoordBancaireHelper.type();
                _tc = orb.create_struct_tc(id(),"DemandeAdhesion",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the DemandeAdhesion IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionUtilisateurs/DemandeAdhesion:1.0";

    /**
     * Read DemandeAdhesion from a marshalled stream
     * @param istream the input stream
     * @return the readed DemandeAdhesion value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion new_one = new OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion();

        new_one.prenomAdherent = istream.read_string();
        new_one.nomAdherent = istream.read_string();
        new_one.adresseAdherent = OperateurDeTransportObjet.AdresseHelper.read(istream);
        new_one.coordonneesBancaires = OperateurDeTransportObjet.CoordBancaireHelper.read(istream);

        return new_one;
    }

    /**
     * Write DemandeAdhesion into a marshalled stream
     * @param ostream the output stream
     * @param value DemandeAdhesion value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion value)
    {
        ostream.write_string(value.prenomAdherent);
        ostream.write_string(value.nomAdherent);
        OperateurDeTransportObjet.AdresseHelper.write(ostream,value.adresseAdherent);
        OperateurDeTransportObjet.CoordBancaireHelper.write(ostream,value.coordonneesBancaires);
    }

}
