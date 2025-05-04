using UnityEngine;

public class ZombieAI : MonoBehaviour
{
    public float moveSpeed = 2f;
    public float detectionRange = 10f;
    public float attackRange = 1.5f;
    public int damage = 10;

    private Transform player;
    private bool isAttacking = false;

    void Start()
    {
        player = GameObject.FindGameObjectWithTag("Player").transform;
    }

    void Update()
    {
        float distanceToPlayer = Vector3.Distance(transform.position, player.position);

        if (distanceToPlayer < detectionRange)
        {
            if (distanceToPlayer > attackRange)
            {
                MoveTowardsPlayer();
            }
            else
            {
                AttackPlayer();
            }
        }
    }

    void MoveTowardsPlayer()
    {
        if (!isAttacking)
        {
            Vector3 direction = (player.position - transform.position).normalized;
            transform.position += direction * moveSpeed * Time.deltaTime;
        }
    }

    void AttackPlayer()
    {
        isAttacking = true;
        // Implement attack logic here (e.g., deal damage to player)
        // Reset isAttacking after a delay or when the player moves away
    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Player"))
        {
            // Trigger attack on player
            // Example: other.GetComponent<HealthSystem>().TakeDamage(damage);
        }
    }
}