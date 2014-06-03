package OperateurDeTransportObjet;

/**
 * Interface definition : GestionUtilisateurs
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionUtilisateursPOA extends org.omg.PortableServer.Servant
        implements GestionUtilisateursOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionUtilisateurs _this()
    {
        return GestionUtilisateursHelper.narrow(_this_object());
    }

    public GestionUtilisateurs _this(org.omg.CORBA.ORB orb)
    {
        return GestionUtilisateursHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionUtilisateurs:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("demandeAdhesion")) {
                return _invoke_demandeAdhesion(_is, handler);
        } else if (opName.equals("demandeInscriptionTrans")) {
                return _invoke_demandeInscriptionTrans(_is, handler);
        } else if (opName.equals("getNumAdherent")) {
                return _invoke_getNumAdherent(_is, handler);
        } else if (opName.equals("verifierAdherent")) {
                return _invoke_verifierAdherent(_is, handler);
        } else if (opName.equals("verifierTransporteur")) {
                return _invoke_verifierTransporteur(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_demandeAdhesion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion arg0_in = OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHelper.read(_is);

        try
        {
            OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion _arg_result = demandeAdhesion(arg0_in);

            _output = handler.createReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHelper.write(_output,_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demandeInscriptionTrans(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans arg0_in = OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTransHelper.read(_is);

        try
        {
            OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans _arg_result = demandeInscriptionTrans(arg0_in);

            _output = handler.createReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTransHelper.write(_output,_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAdherent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        boolean _arg_result = verifierAdherent(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierTransporteur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        boolean _arg_result = verifierTransporteur(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getNumAdherent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            int _arg_result = getNumAdherent(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_long(_arg_result);

        }
        catch (OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}
