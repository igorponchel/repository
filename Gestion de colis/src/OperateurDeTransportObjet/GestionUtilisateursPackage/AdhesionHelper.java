package OperateurDeTransportObjet.GestionUtilisateursPackage;

/** 
 * Helper class for : Adhesion
 *  
 * @author OpenORB Compiler
 */ 
public class AdhesionHelper
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
     * Insert Adhesion into an any
     * @param a an any
     * @param t Adhesion value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHolder(t));
    }

    /**
     * Extract Adhesion from an any
     * @param a an any
     * @return the extracted Adhesion value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHolder)
                    return ((OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHolder h = new OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHolder(read(a.create_input_stream()));
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
     * Return the Adhesion TypeCode
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
                _members[0].name = "numeroAdherent";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomAdherent";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "prenomAdherent";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "zoneAdherent";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Adhesion",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Adhesion IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionUtilisateurs/Adhesion:1.0";

    /**
     * Read Adhesion from a marshalled stream
     * @param istream the input stream
     * @return the readed Adhesion value
     */
    public static OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion new_one = new OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion();

        new_one.numeroAdherent = istream.read_string();
        new_one.nomAdherent = istream.read_string();
        new_one.prenomAdherent = istream.read_string();
        new_one.zoneAdherent = istream.read_string();

        return new_one;
    }

    /**
     * Write Adhesion into a marshalled stream
     * @param ostream the output stream
     * @param value Adhesion value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion value)
    {
        ostream.write_string(value.numeroAdherent);
        ostream.write_string(value.nomAdherent);
        ostream.write_string(value.prenomAdherent);
        ostream.write_string(value.zoneAdherent);
    }

}
