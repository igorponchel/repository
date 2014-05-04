package Convertisseur;

/** 
 * Helper class for : Euro
 *  
 * @author OpenORB Compiler
 */ 
public class EuroHelper
{
    /**
     * Insert Euro into an any
     * @param a an any
     * @param t Euro value
     */
    public static void insert(org.omg.CORBA.Any a, Convertisseur.Euro t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Euro from an any
     * @param a an any
     * @return the extracted Euro value
     */
    public static Convertisseur.Euro extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Convertisseur.EuroHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Euro TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Euro");
        }
        return _tc;
    }

    /**
     * Return the Euro IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Convertisseur/Euro:1.0";

    /**
     * Read Euro from a marshalled stream
     * @param istream the input stream
     * @return the readed Euro value
     */
    public static Convertisseur.Euro read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Convertisseur.Euro)istream.read_Object(Convertisseur._EuroStub.class);
    }

    /**
     * Write Euro into a marshalled stream
     * @param ostream the output stream
     * @param value Euro value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Convertisseur.Euro value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Euro
     * @param obj the CORBA Object
     * @return Euro Object
     */
    public static Euro narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Euro)
            return (Euro)obj;

        if (obj._is_a(id()))
        {
            _EuroStub stub = new _EuroStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Euro
     * @param obj the CORBA Object
     * @return Euro Object
     */
    public static Euro unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Euro)
            return (Euro)obj;

        _EuroStub stub = new _EuroStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
