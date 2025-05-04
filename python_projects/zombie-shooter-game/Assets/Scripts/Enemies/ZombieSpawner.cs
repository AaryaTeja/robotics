using UnityEngine;

public class ZombieSpawner : MonoBehaviour
{
    public GameObject zombiePrefab;
    public float spawnInterval = 3f;
    public int maxZombies = 10;
    private int currentZombieCount = 0;

    private void Start()
    {
        InvokeRepeating("SpawnZombie", spawnInterval, spawnInterval);
    }

    private void SpawnZombie()
    {
        if (currentZombieCount < maxZombies)
        {
            Vector3 spawnPosition = new Vector3(Random.Range(-10f, 10f), 0, Random.Range(-10f, 10f));
            Instantiate(zombiePrefab, spawnPosition, Quaternion.identity);
            currentZombieCount++;
        }
    }

    public void OnZombieDestroyed()
    {
        currentZombieCount--;
    }
}