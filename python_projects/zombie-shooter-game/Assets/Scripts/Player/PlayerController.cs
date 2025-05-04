using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public float moveSpeed = 5f;
    public float rotationSpeed = 700f;
    public HealthSystem healthSystem;
    public AmmoSystem ammoSystem;

    private void Update()
    {
        Move();
        Shoot();
    }

    private void Move()
    {
        float horizontal = Input.GetAxis("Horizontal");
        float vertical = Input.GetAxis("Vertical");

        Vector3 direction = new Vector3(horizontal, 0, vertical).normalized;

        if (direction.magnitude >= 0.1f)
        {
            float targetAngle = Mathf.Atan2(direction.x, direction.z) * Mathf.Rad2Deg;
            float angle = Mathf.MoveTowardsAngle(transform.eulerAngles.y, targetAngle, rotationSpeed * Time.deltaTime);
            transform.rotation = Quaternion.Euler(0, angle, 0);

            Vector3 moveDirection = Quaternion.Euler(0, targetAngle, 0) * Vector3.forward;
            transform.position += moveDirection.normalized * moveSpeed * Time.deltaTime;
        }
    }

    private void Shoot()
    {
        if (Input.GetButtonDown("Fire1") && ammoSystem.CurrentAmmo > 0)
        {
            // Implement shooting logic here
            ammoSystem.UseAmmo();
        }
    }
}