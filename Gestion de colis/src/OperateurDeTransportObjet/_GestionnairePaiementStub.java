package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnairePaiement
 * 
 * @author OpenORB Compiler
 */
public class _GestionnairePaiementStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionnairePaiement
{
    static final String[] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionnairePaiement:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = OperateurDeTransportObjet.GestionnairePaiementOperations.class;

    /**
     * Operation debiter
     */
    public short debiter(OperateurDeTransportObjet.CoordBancaire coordonneesBancaires, int somme)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("debiter",true);
                    OperateurDeTransportObjet.CoordBancaireHelper.write(_output,coordonneesBancaires);
                    _output.write_long(somme);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("debiter",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnairePaiementOperations _self = (OperateurDeTransportObjet.GestionnairePaiementOperations) _so.servant;
                try
                {
                    return _self.debiter( coordonneesBancaires,  somme);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation crediter
     */
    public short crediter(OperateurDeTransportObjet.CoordBancairePro coordonneesBancairesPro, int somme)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("crediter",true);
                    OperateurDeTransportObjet.CoordBancaireProHelper.write(_output,coordonneesBancairesPro);
                    _output.write_long(somme);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("crediter",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnairePaiementOperations _self = (OperateurDeTransportObjet.GestionnairePaiementOperations) _so.servant;
                try
                {
                    return _self.crediter( coordonneesBancairesPro,  somme);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
