package Convertisseur;

/**
 * Interface definition : Euro
 * 
 * @author OpenORB Compiler
 */
public abstract class EuroPOA extends org.omg.PortableServer.Servant
        implements EuroOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Euro _this()
    {
        return EuroHelper.narrow(_this_object());
    }

    public Euro _this(org.omg.CORBA.ORB orb)
    {
        return EuroHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Convertisseur/Euro:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_devise")) {
                return _invoke__get_devise(_is, handler);
        } else if (opName.equals("_get_taux")) {
                return _invoke__get_taux(_is, handler);
        } else if (opName.equals("_set_devise")) {
                return _invoke__set_devise(_is, handler);
        } else if (opName.equals("_set_taux")) {
                return _invoke__set_taux(_is, handler);
        } else if (opName.equals("toDevise")) {
                return _invoke_toDevise(_is, handler);
        } else if (opName.equals("toEuro")) {
                return _invoke_toEuro(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_taux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        double arg = taux();
        _output = handler.createReply();
        _output.write_double(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_taux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        double result = _is.read_double();

        taux(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_devise(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = devise();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_devise(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String result = _is.read_string();

        devise(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_toEuro(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        double arg0_in = _is.read_double();

        double _arg_result = toEuro(arg0_in);

        _output = handler.createReply();
        _output.write_double(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_toDevise(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        double arg0_in = _is.read_double();

        double _arg_result = toDevise(arg0_in);

        _output = handler.createReply();
        _output.write_double(_arg_result);

        return _output;
    }

}
