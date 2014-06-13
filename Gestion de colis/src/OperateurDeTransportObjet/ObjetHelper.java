package OperateurDeTransportObjet;

/** 
 * Helper class for : Objet
 *  
 * @author OpenORB Compiler
 */ 
public class ObjetHelper
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
     * Insert Objet into an any
     * @param a an any
     * @param t Objet value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.Objet t)
    {
        a.insert_Streamable(new OperateurDeTransportObjet.ObjetHolder(t));
    }

    /**
     * Extract Objet from an any
     * @param a an any
     * @return the extracted Objet value
     */
    public static OperateurDeTransportObjet.Objet extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof OperateurDeTransportObjet.ObjetHolder)
                    return ((OperateurDeTransportObjet.ObjetHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            OperateurDeTransportObjet.ObjetHolder h = new OperateurDeTransportObjet.ObjetHolder(read(a.create_input_stream()));
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
     * Return the Objet TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[6];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idObjet";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "etatObjet";
                _members[1].type = OperateurDeTransportObjet.EtatObjetHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "numExpediteur";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "numDestinataire";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "numeroCasierDepart";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "numeroCasierArrivee";
                _members[5].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _tc = orb.create_struct_tc(id(),"Objet",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Objet IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/Objet:1.0";

    /**
     * Read Objet from a marshalled stream
     * @param istream the input stream
     * @return the readed Objet value
     */
    public static OperateurDeTransportObjet.Objet read(org.omg.CORBA.portable.InputStream istream)
    {
        OperateurDeTransportObjet.Objet new_one = new OperateurDeTransportObjet.Objet();

        new_one.idObjet = istream.read_string();
        new_one.etatObjet = OperateurDeTransportObjet.EtatObjetHelper.read(istream);
        new_one.numExpediteur = istream.read_long();
        new_one.numDestinataire = istream.read_long();
        new_one.numeroCasierDepart = istream.read_long();
        new_one.numeroCasierArrivee = istream.read_long();

        return new_one;
    }

    /**
     * Write Objet into a marshalled stream
     * @param ostream the output stream
     * @param value Objet value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.Objet value)
    {
        ostream.write_string(value.idObjet);
        OperateurDeTransportObjet.EtatObjetHelper.write(ostream,value.etatObjet);
        ostream.write_long(value.numExpediteur);
        ostream.write_long(value.numDestinataire);
        ostream.write_long(value.numeroCasierDepart);
        ostream.write_long(value.numeroCasierArrivee);
    }

}