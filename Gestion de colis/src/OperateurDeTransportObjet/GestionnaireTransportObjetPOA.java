package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnaireTransportObjet
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionnaireTransportObjetPOA extends org.omg.PortableServer.Servant
        implements GestionnaireTransportObjetOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionnaireTransportObjet _this()
    {
        return GestionnaireTransportObjetHelper.narrow(_this_object());
    }

    public GestionnaireTransportObjet _this(org.omg.CORBA.ORB orb)
    {
        return GestionnaireTransportObjetHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("consulterEtatObjet")) {
                return _invoke_consulterEtatObjet(_is, handler);
        } else if (opName.equals("notifierEtatObjet")) {
                return _invoke_notifierEtatObjet(_is, handler);
        } else if (opName.equals("notifierOffreAcceptee")) {
                return _invoke_notifierOffreAcceptee(_is, handler);
        } else if (opName.equals("notifierOffreTransport")) {
                return _invoke_notifierOffreTransport(_is, handler);
        } else if (opName.equals("verifierTransporteur")) {
                return _invoke_verifierTransporteur(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_notifierOffreTransport(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        String _arg_result = notifierOffreTransport(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierOffreAcceptee(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        String _arg_result = notifierOffreAcceptee(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierTransporteur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        String arg1_in = _is.read_string();

        boolean _arg_result = verifierTransporteur(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_notifierEtatObjet(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet arg1_in = OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjetHelper.read(_is);

        try
        {
            notifierEtatObjet(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterEtatObjet(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet _arg_result = consulterEtatObjet(arg0_in);

            _output = handler.createReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjetHelper.write(_output,_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}
