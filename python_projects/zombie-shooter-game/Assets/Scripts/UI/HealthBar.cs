using UnityEngine;
using UnityEngine.UI;

public class HealthBar : MonoBehaviour
{
    public Slider healthSlider;

    private void Start()
    {
        // Initialize health bar
        healthSlider.value = 1f; // Assuming full health at start
    }

    public void SetHealth(float healthPercentage)
    {
        healthSlider.value = healthPercentage;
    }
}