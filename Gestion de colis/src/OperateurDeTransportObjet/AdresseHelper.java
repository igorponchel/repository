package OperateurDeTransportObjet;

/** 
 * Helper class for : Adresse
 *  
 * @author OpenORB Compiler
 */ 
public class AdresseHelper
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
     * Insert Adresse into an any
     * @param a an any
     * @param t Adresse value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.Adresse t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.AdresseHolder(t));
    }

    /**
     * Extract Adresse from an any
     * @param a an any
     * @return the extracted Adresse value
     */
    public static OperateurDeTransportObjet.Adresse extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.AdresseHolder)
                    return ((OperateurDeTransportObjet.AdresseHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.AdresseHolder h = new OperateurDeTransportObjet.AdresseHolder(read(a.create_input_stream()));
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
     * Return the Adresse TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[5];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "numeroRue";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomRue";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "ville";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "departement";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "pays";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Adresse",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Adresse IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/Adresse:1.0";

    /**
     * Read Adresse from a marshalled stream
     * @param istream the input stream
     * @return the readed Adresse value
     */
    public static OperateurDeTransportObjet.Adresse read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.Adresse new_one = new OperateurDeTransportObjet.Adresse();

        new_one.numeroRue = istream.read_string();
        new_one.nomRue = istream.read_string();
        new_one.ville = istream.read_string();
        new_one.departement = istream.read_long();
        new_one.pays = istream.read_string();

        return new_one;
    }

    /**
     * Write Adresse into a marshalled stream
     * @param ostream the output stream
     * @param value Adresse value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.Adresse value)
    {
        ostream.write_string(value.numeroRue);
        ostream.write_string(value.nomRue);
        ostream.write_string(value.ville);
        ostream.write_long(value.departement);
        ostream.write_string(value.pays);
    }

}
