using UnityEngine;
using UnityEngine.UI;

public class AmmoDisplay : MonoBehaviour
{
    public Text ammoText;
    private AmmoSystem ammoSystem;

    void Start()
    {
        ammoSystem = FindObjectOfType<AmmoSystem>();
        UpdateAmmoDisplay();
    }

    void Update()
    {
        UpdateAmmoDisplay();
    }

    void UpdateAmmoDisplay()
    {
        if (ammoSystem != null)
        {
            ammoText.text = "Ammo: " + ammoSystem.GetCurrentAmmo() + "/" + ammoSystem.GetMaxAmmo();
        }
    }
}