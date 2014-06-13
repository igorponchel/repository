package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/** 
 * Helper class for : InscriptionTrans
 *  
 * @author OpenORB Compiler
 */ 
public class InscriptionTransHelper
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
     * Insert InscriptionTrans into an any
     * @param a an any
     * @param t InscriptionTrans value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTransHolder(t));
    }

    /**
     * Extract InscriptionTrans from an any
     * @param a an any
     * @return the extracted InscriptionTrans value
     */
    public static OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTransHolder)
                    return ((OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTransHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTransHolder h = new OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTransHolder(read(a.create_input_stream()));
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
     * Return the InscriptionTrans TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "numeroInscritTrans";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomTransporteur";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"InscriptionTrans",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the InscriptionTrans IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet/InscriptionTrans:1.0";

    /**
     * Read InscriptionTrans from a marshalled stream
     * @param istream the input stream
     * @return the readed InscriptionTrans value
     */
    public static OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans new_one = new OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans();

        new_one.numeroInscritTrans = istream.read_long();
        new_one.nomTransporteur = istream.read_string();

        return new_one;
    }

    /**
     * Write InscriptionTrans into a marshalled stream
     * @param ostream the output stream
     * @param value InscriptionTrans value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans value)
    {
        ostream.write_long(value.numeroInscritTrans);
        ostream.write_string(value.nomTransporteur);
    }

}
