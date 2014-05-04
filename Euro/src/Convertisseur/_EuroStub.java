package Convertisseur;

/**
 * Interface definition : Euro
 * 
 * @author OpenORB Compiler
 */
public class _EuroStub extends org.omg.CORBA.portable.ObjectImpl
        implements Euro
{
    static final String[] _ids_list =
    {
        "IDL:Convertisseur/Euro:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Convertisseur.EuroOperations.class;

    /**
     * Read accessor for taux attribute
     * @return the attribute value
     */
    public double taux()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_taux",true);
                    _input = this._invoke(_output);
                    return _input.read_double();
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_taux",_opsClass);
                if (_so == null)
                   continue;
                Convertisseur.EuroOperations _self = (Convertisseur.EuroOperations) _so.servant;
                try
                {
                    return _self.taux();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for taux attribute
     * @param value the attribute value
     */
    public void taux(double value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_taux",true);
                    _output.write_double(value);
                    _input = this._invoke(_output);
                    return;
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_taux",_opsClass);
                if (_so == null)
                   continue;
                Convertisseur.EuroOperations _self = (Convertisseur.EuroOperations) _so.servant;
                try
                {
                    _self.taux(value);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for devise attribute
     * @return the attribute value
     */
    public String devise()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_devise",true);
                    _input = this._invoke(_output);
                    return _input.read_string();
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_devise",_opsClass);
                if (_so == null)
                   continue;
                Convertisseur.EuroOperations _self = (Convertisseur.EuroOperations) _so.servant;
                try
                {
                    return _self.devise();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for devise attribute
     * @param value the attribute value
     */
    public void devise(String value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_devise",true);
                    _output.write_string(value);
                    _input = this._invoke(_output);
                    return;
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_devise",_opsClass);
                if (_so == null)
                   continue;
                Convertisseur.EuroOperations _self = (Convertisseur.EuroOperations) _so.servant;
                try
                {
                    _self.devise(value);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation toEuro
     */
    public double toEuro(double devise)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("toEuro",true);
                    _output.write_double(devise);
                    _input = this._invoke(_output);
                    double _arg_ret = _input.read_double();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("toEuro",_opsClass);
                if (_so == null)
                   continue;
                Convertisseur.EuroOperations _self = (Convertisseur.EuroOperations) _so.servant;
                try
                {
                    return _self.toEuro( devise);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation toDevise
     */
    public double toDevise(double euro)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("toDevise",true);
                    _output.write_double(euro);
                    _input = this._invoke(_output);
                    double _arg_ret = _input.read_double();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("toDevise",_opsClass);
                if (_so == null)
                   continue;
                Convertisseur.EuroOperations _self = (Convertisseur.EuroOperations) _so.servant;
                try
                {
                    return _self.toDevise( euro);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
